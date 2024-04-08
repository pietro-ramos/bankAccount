package entities.Enum;

public enum ClientType {
    PRATA(30.0),
    BRONZE(20.0),
    OURO(10.0),
    DIAMANTE(0.0);

    private final double maintenanceFee;

    ClientType(double maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public double getMaintenanceFee() {
        return maintenanceFee;
    }
}
