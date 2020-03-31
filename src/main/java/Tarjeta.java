public class Tarjeta implements FormaDePago {
    private Integer cantidadDeCuotas;
    private double coeficienteFijo;

    public Tarjeta(Integer cantidadDeCuotas, double coeficienteFijo) {
        this.cantidadDeCuotas = cantidadDeCuotas;
        this.coeficienteFijo = coeficienteFijo;
    }

    @Override
    public double modificarMonto(Double montoTotal) {
        return montoTotal + (cantidadDeCuotas * coeficienteFijo + 0.01 * montoTotal);
    }
}
