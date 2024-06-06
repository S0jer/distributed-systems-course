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
        if (event.getType() == Event.EventType.NodeCreated) {
            handleNodeCreatedEvent(event);
        } else if (event.getType() == Event.EventType.NodeDeleted) {
            handleNodeDeletedEvent(event);
        }
    }

    private void handleNodeCreatedEvent(WatchedEvent event) {
        System.out.println("zNode created, path: " + event.getPath());
        try {
            printTree();
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }

        if (Objects.equals(event.getPath(), "/a")) {
            openExternalApp();
        } else {
            try {
                int numChildren = zooKeeper.getAllChildrenNumber("/a");
                System.out.println("zNode /a number of children: " + numChildren);
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleNodeDeletedEvent(WatchedEvent event) {
        System.out.println("zNode deleted, path: " + event.getPath());
        if (Objects.equals(event.getPath(), "/a")) {
            System.out.println("Killing app");
            if (process != null) {
                process.destroy();
            }
        }
    }

    private void openExternalApp() {
        System.out.println("Opening app...");
        String appLocation = "C:\\Users\\Paweł\\AppData\\Local\\Microsoft\\WindowsApps\\Microsoft.Paint_8wekyb3d8bbwe\\mspaint.exe";
        try {
            ProcessBuilder builder = new ProcessBuilder(appLocation);
            process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printTree() throws IOException, InterruptedException, KeeperException {
        List<String> tree = getTree();
        for (String child : tree) {
            System.out.println(child);
        }
    }

    private List<String> getTree() throws InterruptedException, KeeperException {
        List<String> tree = new ArrayList<>();
        traverseTree("/a", "", tree);
        return tree;
    }

    private void traverseTree(String node, String indent, List<String> tree) throws InterruptedException, KeeperException {
        String formattedPath = formatNodePath(node);
        tree.add(indent + formattedPath);

        List<String> children = zooKeeper.getChildren(node, false);
        for (String child : children) {
            String childNode = node + "/" + child;
            traverseTree(childNode, indent + "\t", tree);
        }
    }

    private String formatNodePath(String nodePath) {
        String[] parts = nodePath.split("/");
        return "/" + parts[parts.length - 1];
    }
}
