package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.*;
import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRecomendacionesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionesController {
    @Autowired
    private IRecomendacionesService rS;

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody RecomendacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendaciones p = m.map(dto, Recomendaciones.class);
        rS.insertar_Recomendacion(p);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping
    public List<RecomendacionesDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }


    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){rS.deleteRecomendacion(id);}

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/{id}")
    public RecomendacionesDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RecomendacionesDTO dto=m.map(rS.listRecomendacionById(id),RecomendacionesDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody RecomendacionesDTO dto){
        ModelMapper m=new ModelMapper();
        Recomendaciones r = m.map(dto, Recomendaciones.class);
        rS.updateRecomendacion(r);
    }

//    @GetMapping("/BuscarRecomendacionesPorIdUsuario")
//    public List<RecomendacionesDTO> BuscarPorUsuario(@RequestParam int idUsuario) {
//        return rS.getRecomendacionesByUserId(idUsuario).stream().map(x->{
//            ModelMapper m=new ModelMapper();
//            return m.map(x, RecomendacionesDTO.class);
//        }).collect(Collectors.toList());
//    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/BuscarRecomendacionesPorIdTendencia")
    public List<RecomendacionesDTO> BuscarPorTendencia(@RequestParam int idTendencia) {
        return rS.getRecomendacionesByTrendId(idTendencia).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/TotalRecomendacionesPorIntervalo")
    public RecomendacionesPorIntervaloDTO obtenerPorIntervalo(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        // Obtén el total de recomendaciones del servicio
        Long totalRecomendaciones = rS.obtenerTotalRecomendacionesPorIntervalo(fechaInicio, fechaFin);
        // Crea y configura el DTO
        RecomendacionesPorIntervaloDTO dto = new RecomendacionesPorIntervaloDTO();
        dto.setFechaInicio(fechaInicio);
        dto.setFechaFin(fechaFin);
        dto.setTotalRecomendaciones(totalRecomendaciones);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/TopUsuariosConMasRecomendaciones")
    public List<ReUsuariosConMasRecomendacionesDTO> obtenerTopUsuarios(@RequestParam int topN) {
        List<String[]> lista = rS.obtenerTopNUsuariosConMasRecomendaciones(topN);
        List<ReUsuariosConMasRecomendacionesDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ReUsuariosConMasRecomendacionesDTO dto = new ReUsuariosConMasRecomendacionesDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setNombre_usuario(columna[1]);
            dto.setTotal_recomendaciones((long) Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/TopTendenciasConMasRecomendaciones")
    public List<ReTendenciasConMasRecomendacionesDTO> obtenerTopTendencias(@RequestParam int topN) {
        List<String[]> lista = rS.obtenerTopTendenciasConMasRecomendaciones(topN);
        List<ReTendenciasConMasRecomendacionesDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ReTendenciasConMasRecomendacionesDTO dto = new ReTendenciasConMasRecomendacionesDTO();
            dto.setId_Tendencia(Integer.parseInt(columna[0]));
            dto.setNombre_tendencia(columna[1]);
            dto.setTotal_recomendaciones(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
