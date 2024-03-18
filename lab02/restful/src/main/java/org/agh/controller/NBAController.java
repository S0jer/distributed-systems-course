package org.agh.controller;


import lombok.RequiredArgsConstructor;
import org.agh.model.player.Player;
import org.agh.model.player.PlayerData;
import org.agh.service.NBAService;
import org.agh.service.ViewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class NBAController {

    private final NBAService nbaService;

    private final ViewService viewService;

    @Value("${app.season}")
    private Integer currentSeason;

    @GetMapping("/search")
    public String showSearchPage() {
        return viewService.getSearchPage();
    }

    @PostMapping("/search")
    public String retrievePlayerInfo(@ModelAttribute PlayerData playerData,
                                     RedirectAttributes redirectAttributes) {
        Player player = nbaService.retrievePlayerInfo(playerData);
        List<Player> team = nbaService.retrievePlayerTeam(player.getTeam().getId());
        String quote = nbaService.getMotivationalQuote();

        redirectAttributes.addFlashAttribute("player", player);
        redirectAttributes.addFlashAttribute("team", team);
        redirectAttributes.addFlashAttribute("quote", quote);

        return "redirect:/result";
    }

    @GetMapping("result")
    public String showResultPage() {
        return viewService.getResultPage();
    }

    @GetMapping("/error")
    public String showErrorPage(Model model) {
        return "500";
    }
}
