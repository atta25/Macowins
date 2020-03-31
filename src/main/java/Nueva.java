public class Nueva implements Estado {
    @Override
    public double getPrecio(Prenda prenda) {
        return prenda.getPrecioBase();
    }
}
