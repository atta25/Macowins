import java.time.LocalDate;
import java.util.List;

public class Empresa {
    private List<Venta> ventas;

    public Empresa(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public double gananciasDe(LocalDate fechaDeterminada) {
        return ventas.stream().filter(venta -> venta.esDeFecha(fechaDeterminada)).mapToDouble(Venta::precio).sum();
    }
}
