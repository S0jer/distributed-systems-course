package agh.edu.pl;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.*;

public class App implements Watcher {
    private final ZooKeeper zooKeeper;
    private Process process;

    public App() throws IOException {
        this.zooKeeper = new ZooKeeper("localhost:2181", 3000, this);
    }

    public void run() throws InterruptedException, KeeperException {
        zooKeeper.addWatch("/a", AddWatchMode.PERSISTENT_RECURSIVE);
        while (true) {
            Thread.sleep(1000);
        }
    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case NodeCreated -> handleNodeCreated(event);
            case NodeDeleted -> handleNodeDeleted(event);
            default -> {
            }
        }
    }

    private void handleNodeCreated(WatchedEvent event) {
        System.out.println("zNode created, path: " + event.getPath());
        try {
            displayTree();
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }

        if ("/a".equals(event.getPath())) {
            launchExternalApp();
        } else {
            try {
                int childrenCount = zooKeeper.getAllChildrenNumber("/a");
                System.out.println("zNode /a number of children: " + childrenCount);
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleNodeDeleted(WatchedEvent event) {
        System.out.println("zNode deleted, path: " + event.getPath());
        if ("/a".equals(event.getPath())) {
            System.out.println("Terminating app");
            if (process != null) {
                process.destroy();
            }
        }
    }

    private void launchExternalApp() {
        System.out.println("Launching external app...");
        String appPath = "C:\\Users\\Paweł\\AppData\\Local\\Microsoft\\WindowsApps\\Microsoft.Paint_8wekyb3d8bbwe\\mspaint.exe";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(appPath);
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayTree() throws IOException, InterruptedException, KeeperException {
        List<String> tree = buildTree();
        tree.forEach(System.out::println);
    }

    private List<String> buildTree() throws InterruptedException, KeeperException {
        List<String> tree = new ArrayList<>();
        exploreTree("/a", "", tree);
        return tree;
    }

    private void exploreTree(String node, String indent, List<String> tree) throws InterruptedException, KeeperException {
        String formattedNode = formatPath(node);
        tree.add(indent + formattedNode);

        List<String> children = zooKeeper.getChildren(node, false);
        traverseChildren(node, indent, tree, children);
    }

    private void traverseChildren(String node, String indent, List<String> tree, List<String> children) throws InterruptedException, KeeperException {
        for (String child : children) {
            String childPath = node + "/" + child;
            exploreTree(childPath, indent + "\t", tree);
        }
    }

    private String formatPath(String path) {
        String[] parts = path.split("/");
        return "/" + parts[parts.length - 1];
    }
}
