package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void registrar(@RequestBody RecomendacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendaciones p = m.map(dto, Recomendaciones.class);
        rS.insertar_Recomendacion(p);
    }

    @GetMapping
    public List<RecomendacionesDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){rS.deleteRecomendacion(id);}


    @GetMapping("/{id}")
    public RecomendacionesDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RecomendacionesDTO dto=m.map(rS.listRecomendacionById(id),RecomendacionesDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RecomendacionesDTO dto){
        ModelMapper m=new ModelMapper();
        Recomendaciones r = m.map(dto, Recomendaciones.class);
        rS.updateRecomendacion(r);
    }

    @GetMapping("/BuscarRecomendacionesPorIdUsuario")
    public List<RecomendacionesDTO> BuscarPorUsuario(@RequestParam int idUsuario) {
        return rS.getRecomendacionesByUserId(idUsuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/BuscarRecomendacionesPorIdTendencia")
    public List<RecomendacionesDTO> BuscarPorTendencia(@RequestParam int idTendencia) {
        return rS.getRecomendacionesByTrendId(idTendencia).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/TotalRecomendacionsPorIDusuario")
    public List<RecomendacionesPorIDusuarioDTO> cantidad(){
        List<String[]> lista=rS.obtenerTotalRecomendacionesPorIDUsuario();
        List<RecomendacionesPorIDusuarioDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            RecomendacionesPorIDusuarioDTO dto=new RecomendacionesPorIDusuarioDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setTotal_recomendaciones((long) Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/TotalRecomendacionsPorIDTendencia")
    public List<RecomendacionesPorIDTendenciaDTO> cantidad1(){
        List<String[]> lista=rS.obtenerTotalRecomendacionesPorIDTendencia();
        List<RecomendacionesPorIDTendenciaDTO> listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            RecomendacionesPorIDTendenciaDTO dto=new RecomendacionesPorIDTendenciaDTO();
            dto.setId_tendencias(Integer.parseInt(columna[0]));
            dto.setTotal_recomendaciones((long) Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

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

    @GetMapping("/TopTendenciasConMasRecomendaciones")
    public List<ReTendenciasConMasRecomendacionesDTO> obtenerTopTendencias(@RequestParam int topN) {
        List<String[]> lista = rS.obtenerTopTendenciasConMasRecomendaciones(topN);
        List<ReTendenciasConMasRecomendacionesDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ReTendenciasConMasRecomendacionesDTO dto = new ReTendenciasConMasRecomendacionesDTO();
            dto.setId_Tendencia(Integer.parseInt(columna[0]));
            dto.setNombre_tendencia(columna[1]);
            dto.setTotal_recomendaciones((long) Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
