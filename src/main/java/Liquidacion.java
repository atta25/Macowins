public class Liquidacion implements Estado {
    @Override
    public double getPrecio(Prenda prenda) {
        return prenda.getPrecioBase() / 2;
    }
}
