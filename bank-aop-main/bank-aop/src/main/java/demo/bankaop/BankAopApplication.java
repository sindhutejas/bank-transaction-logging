
package demo.bankaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAopApplication.class, args);
    }

    @Bean
    CommandLineRunner run(BankService bankService) {
        return args -> {

            bankService.deposit(1000);

            bankService.withdraw(250);

            try {
                bankService.withdraw(5000);
            } catch (IllegalArgumentException ex) {
                System.out.println("Handled error: " + ex.getMessage());
            }
        };
    }
}

