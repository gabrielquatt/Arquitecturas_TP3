package repository;

import clases.Estado;

import java.util.List;

public interface EstadoRepository {

    boolean InsertEstado(Estado e);

    List<Estado> GetEstados();

}
