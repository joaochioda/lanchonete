package lanchonete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LanchoneteApi {

//    @Autowired
//    private LancheRepository lancheRepo;
//
//    @Component
//    class DataSetup implements ApplicationRunner {
//        @Override
//        public void run(ApplicationArguments args) throws Exception{
//            lancheRepo.save(Lanche.builder().id("1").name("xBacon").price(19.90).build());
//        }
//    }
    public static void main(String[] args) {
        SpringApplication.run(LanchoneteApi.class, args);
    }
}
