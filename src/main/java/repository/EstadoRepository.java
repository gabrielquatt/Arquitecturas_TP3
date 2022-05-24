package repository;

import clases.Estado;

import java.util.List;

public interface EstadoRepository {

    void InsertEstado(Estado e);

    List<Estado> GetEstados();

}
