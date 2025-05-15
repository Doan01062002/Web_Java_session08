package com.example.session08.controller;

import com.example.session08.model.CropSeed;
import com.example.session08.model.FarmerUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("activeFarmer")
public class FarmGameController {

    private List<FarmerUser> farmerList = new ArrayList<>();
    private List<CropSeed> seedInventory = new ArrayList<>();

    public FarmGameController() {
        seedInventory.add(new CropSeed(1, "Cà chua đỏ", 2000, "tomato.jpg"));
        seedInventory.add(new CropSeed(2, "Ngô ngọt", 1500, "corn.jpg"));
        seedInventory.add(new CropSeed(3, "Dưa hấu mát lạnh", 2500, "watermelon.jpg"));
    }

    @ModelAttribute("activeFarmer")
    public Optional<FarmerUser> defaultFarmer() {
        return Optional.empty();
    }

    @GetMapping("/homefarm")
    public String toHome(Model model, @ModelAttribute("activeFarmer") Optional<FarmerUser> user) {
        return user.isEmpty() ? "redirect:/dangky" : "homefarm";
    }

    @GetMapping("/dangky")
    public String showSignup(Model model) {
        model.addAttribute("newFarmer", new FarmerUser());
        return "registerfarm";
    }

    @PostMapping("/dangky")
    public String handleSignup(@ModelAttribute("newFarmer") FarmerUser farmer, Model model) {
        farmerList.add(farmer);
        model.addAttribute("activeFarmer", farmer);
        return "redirect:/registerfarm";
    }

    @GetMapping("/dangnhap")
    public String showLogin(Model model) {
        model.addAttribute("loginFarmer", new FarmerUser());
        return "loginfarm";
    }

    @PostMapping("/dangnhap")
    public String handleLogin(@ModelAttribute("loginFarmer") FarmerUser input, Model model) {
        for (FarmerUser f : farmerList) {
            if (f.getFarmerName().equals(input.getFarmerName()) &&
                    f.getFarmerPass().equals(input.getFarmerPass())) {
                model.addAttribute("activeFarmer", f);
                return "redirect:/loginfarm";
            }
        }
        model.addAttribute("error", "Thông tin không chính xác.");
        return "loginfarm";
    }

    @GetMapping("/cuahang")
    public String showSeedShop(Model model, @ModelAttribute("activeFarmer") Optional<FarmerUser> user) {
        if (user.isEmpty()) return "redirect:/dangky";
        model.addAttribute("allSeeds", seedInventory);
        return "seedshop";
    }
}
