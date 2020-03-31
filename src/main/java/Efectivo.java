public class Efectivo implements FormaDePago {
    @Override
    public double modificarMonto(Double montoTotal) {
        return montoTotal;
    }
}
