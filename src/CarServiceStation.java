import java.util.*;

abstract class Vehicle {
    protected String vehicleType;

    public String getVehicleType() {
        return vehicleType;
    }
}

class Hatchback extends Vehicle {
    public Hatchback() {
        vehicleType = "Hatchback";
    }
}

class Sedan extends Vehicle {
    public Sedan() {
        vehicleType = "Sedan";
    }
}

class SUV extends Vehicle {
    public SUV() {
        vehicleType = "SUV";
    }
}

abstract class MaintenanceService {
    protected String serviceCode;
    protected Map<String, Integer> prices;

    public MaintenanceService() {
        prices = new HashMap<>();
        prices.put("Hatchback", 0);
        prices.put("Sedan", 0);
        prices.put("SUV", 0);
    }

    public abstract int calculateTotalBill(Vehicle vehicle);

    public void setPrice(String vehicleType, int price) {
        prices.put(vehicleType, price);
    }
}

class BasicService extends MaintenanceService {
    public BasicService() {
        serviceCode = "BS01";
        setPrice("Hatchback", 2000);
        setPrice("Sedan", 4000);
        setPrice("SUV", 5000);
    }

    @Override
    public int calculateTotalBill(Vehicle vehicle) {
        return prices.get(vehicle.getVehicleType());
    }
}

class EngineFixing extends MaintenanceService {
    public EngineFixing() {
        serviceCode = "EF01";
        setPrice("Hatchback", 5000);
        setPrice("Sedan", 8000);
        setPrice("SUV", 10000);
    }

    @Override
    public int calculateTotalBill(Vehicle vehicle) {
        return prices.get(vehicle.getVehicleType());
    }
}

class ClutchFixing extends MaintenanceService {
    public ClutchFixing() {
        serviceCode = "CF01";
        setPrice("Hatchback", 2000);
        setPrice("Sedan", 4000);
        setPrice("SUV", 6000);
    }

    @Override
    public int calculateTotalBill(Vehicle vehicle) {
        return prices.get(vehicle.getVehicleType());
    }
}

class BrakeFixing extends MaintenanceService {
    public BrakeFixing() {
        serviceCode = "BF01";
        setPrice("Hatchback", 1000);
        setPrice("Sedan", 1500);
        setPrice("SUV", 2500);
    }

    @Override
    public int calculateTotalBill(Vehicle vehicle) {
        return prices.get(vehicle.getVehicleType());
    }
}

class GearFixing extends MaintenanceService {
    public GearFixing() {
        serviceCode = "GF01";
        setPrice("Hatchback", 3000);
        setPrice("Sedan", 6000);
        setPrice("SUV", 8000);
    }

    @Override
    public int calculateTotalBill(Vehicle vehicle) {
        return prices.get(vehicle.getVehicleType());
    }
}

class MaintenanceServiceFactory {
    public static MaintenanceService getService(String serviceCode) {
        if (serviceCode.equalsIgnoreCase("BS01")) {
            return new BasicService();
        } else if (serviceCode.equalsIgnoreCase("EF01")) {
            return new EngineFixing();
        } else if (serviceCode.equalsIgnoreCase("CF01")) {
            return new ClutchFixing();
        } else if (serviceCode.equalsIgnoreCase("BF01")) {
            return new BrakeFixing();
        } else if (serviceCode.equalsIgnoreCase("GF01")) {
            return new GearFixing();
        }
        return null;
    }
}

class ServiceInvoice {
    private Vehicle vehicle;
    private List<MaintenanceService> services;

    public ServiceInvoice(Vehicle vehicle) {
        this.vehicle = vehicle;
        services = new ArrayList<>();
    }

    public void addService(String serviceCode) {
        MaintenanceService service = MaintenanceServiceFactory.getService(serviceCode);
        if (service != null) {
            services.add(service);
        }
    }

    public int calculateTotalBill() {
        int totalBill = 0;
        for (MaintenanceService service : services) {
            totalBill += service.calculateTotalBill(vehicle);
        }
        return totalBill;
    }
}

public class CarServiceStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Auto Service Station");
        System.out.println("Available Vehicle Types:");
        System.out.println("1. Hatchback");
        System.out.println("2. Sedan");
        System.out.println("3. SUV");
        System.out.print("Select the Vehicle Type (1-3): ");
        int vehicleTypeChoice = scanner.nextInt();
        Vehicle vehicle;

        switch (vehicleTypeChoice) {
            case 1:
                vehicle = new Hatchback();
                break;
            case 2:
                vehicle = new Sedan();
                break;
            case 3:
                vehicle = new SUV();
                break;
            default:
                System.out.println("Invalid choice. Exiting the program.");
                return;
        }

        ServiceInvoice serviceInvoice = new ServiceInvoice(vehicle);

        System.out.println("\nAvailable Services:");
        System.out.println("BS01 - Basic Servicing");
        System.out.println("EF01 - Engine Fixing");
        System.out.println("CF01 - Clutch Fixing");
        System.out.println("BF01 - Brake Fixing");
        System.out.println("GF01 - Gear Fixing");

        while (true) {
            System.out.print("\nEnter the Service Code (or '0' to finish selecting services): ");
            String serviceCode = scanner.next();
            if (serviceCode.equals("0")) {
                break;
            }
            serviceInvoice.addService(serviceCode);
        }

        int totalBill = serviceInvoice.calculateTotalBill();
        System.out.println("\nType of Vehicle: " + vehicle.getVehicleType());
        System.out.println("Total Bill: ₹" + totalBill);
        if (totalBill > 10000) {
            System.out.println("Complimentary cleaning provided.");
        }
    }
}
