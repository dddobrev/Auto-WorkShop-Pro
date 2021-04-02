package com.example.AutoWorkShop.init;

import com.example.AutoWorkShop.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;


@Controller
@Transactional
public class AutoWorkShopApplicationInit implements CommandLineRunner {

    private final CarService carService;
    private final RepairService repairService;
    private final UserService userService;
    private final ClientService clientService;
    private final SupplierService supplierService;


    public AutoWorkShopApplicationInit(CarService carService,
                                       RepairService repairService,
                                       UserService userService,
                                       ClientService clientService,
                                       SupplierService supplierService) {
        this.carService = carService;
        this.repairService = repairService;
        this.userService = userService;
        this.clientService = clientService;
        this.supplierService = supplierService;

    }

    @Override
    public void run(String... args) throws Exception {

        userService.seedUsers();
        supplierService.seedSuppliers();




//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please put car info ");
//        String input = scanner.nextLine();
//        String input2 = scanner.nextLine();
//        if (input.equalsIgnoreCase("car")) {
//            String brand = scanner.nextLine();
//        }
//        CarEntity carEntityByRegNumber = this.carService.findCarByRegNumber(input);
//        CarEntity carEntityByRegNumber = this.carService.findCarByVin(input);
//        List<RepairEntity> carByRegNumber = this.repairService.findOrderByCarName(input);
//        List<RepairEntity> carByRegNumber = this.repairService.findAllByCarVin(input);
//        if (carEntityByRegNumber != null) {
//            System.out.printf("%s %s, engine %s, volume %s sm3, VIN: %s, %s",
//                    carEntityByRegNumber.getBrand(),
//                    carEntityByRegNumber.getModel(),
//                    carEntityByRegNumber.getEngine(),
//                    carEntityByRegNumber.getVolume(),
//                    carEntityByRegNumber.getVin(),
//                    carEntityByRegNumber.getClient().getFirstName());
//
//        } else {
//            System.out.println("not found");
//        }
//        carByRegNumber.forEach(c->{
//            System.out.printf("%s %s, VIN:%s, %s",
//                    c.getCar().getBrand(),
//                    c.getCar().getModel(),
//                    c.getCar().getVin(),
//                    c.getCar().getRepairs());
//        });

//        List<ClientViewModel> clientByTelephone = clientService.findClientByTelephone(input);
//        clientByTelephone
//        .forEach(c-> System.out.printf("%s %s %s %n", c.getFirstName(), c.getSecondName(), c.getTelephone()));
//        List<CarViewModel> carViewModels = carService.findCarByBrandAndModel(input, input2);
//
//        carViewModels.forEach(car -> System.out.printf("%s %s engine: %s %s VIN: %s %s km %d  client %s%n",
//                car.getBrand(), car.getModel(), car.getEngine(),
//                car.getFuel(), car.getVin(), car.getRegNumber(),
//                car.getMileage(), car.getClient().getFirstName()));
    }
}
