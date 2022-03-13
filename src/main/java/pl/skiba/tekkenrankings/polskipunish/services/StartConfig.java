package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Game;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels.AppUser;
import pl.skiba.tekkenrankings.polskipunish.repo.AppUserRepo;
import pl.skiba.tekkenrankings.polskipunish.repo.GameRepo;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartConfig {

    private AppUserRepo appUserRepo;
    private GameRepo gameRepo;

    public StartConfig(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder, GameRepo gameRepo ) {
        this.appUserRepo = appUserRepo;

        AppUser admin = new AppUser();
        admin.setUsername("jan");
        admin.setPassword(passwordEncoder.encode("nowak"));
        admin.setRole("ROLE_ADMIN");
        admin.setEnabled(true);
        appUserRepo.save(admin);

        AppUser appUser = new AppUser();
        appUser.setUsername("marek");
        appUser.setPassword(passwordEncoder.encode("marek"));
        appUser.setRole("ROLE_USER");
        appUser.setEnabled(true);
        appUserRepo.save(appUser);

        List<Tournament> list = new ArrayList<>();
        gameRepo.save(new Game("Tekken 7", list));
        gameRepo.save(new Game("Soul Calibur 6", list));
        gameRepo.save(new Game("Street Fighter 5", list));
    }
}