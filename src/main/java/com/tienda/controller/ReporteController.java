package com.tienda.controller;

import com.tienda.service.ReporteService;
import java.io.IOException; 
import java.util.Calendar;
import java.util.HashMap; 
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/reportes")
public class ReporteController{
    
    @Autowired
    ReporteService reporteService;
    
    @GetMapping ("/principal")
    public String principal (Model model) {
            Calendar fecha=Calendar.getInstance(); 
            String fechaIni=""+ (fecha.get(Calendar.YEAR)-1)+"-01-01";
            
            String strMes=(fecha.get(Calendar.MONTH) <10?"0":"")+ 
                    fecha.get(Calendar.MONTH);
            String strDia =(fecha.get(Calendar.DAY_OF_MONTH)<10?"0":"")+
                    fecha.get (Calendar.DAY_OF_MONTH);
            String fechaFin=""+fecha.get(Calendar.YEAR)+"-"+strMes+"="+strDia;
            
            model.addAttribute ("fechaInicio", fechaIni);
            model.addAttribute ("fechaFin", fechaFin);
            return "/reportes/principal";
        }
    
    @GetMapping("/usuarios")
    public ResponseEntity<Resource> reporteClientes (@RequestParam String tipo)
            throws IOException { 
        var reporte ="usuarios";
        return reporteService.generaReporte (reporte, null, tipo);
    }



    @GetMapping("/ventas")
    public ResponseEntity<Resource> reporteVentas(@RequestParam String tipo)
            throws IOException{
        var reporte="ventas";
        return reporteService.generaReporte (reporte, null, tipo);
    }



    @GetMapping("/ventasTotales")
    public ResponseEntity<Resource> reporteVentasTotales(
            @RequestParam String fechaInicio, 
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {
        //Esto espara definir los parámetros que se pasan al reporte cliente 
        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte="ventasTotales";
        return reporteService.generaReporte (reporte, parametros,tipo);
 }
}