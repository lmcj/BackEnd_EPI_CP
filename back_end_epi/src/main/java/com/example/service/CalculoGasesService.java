package com.example.service;

import com.example.domain.CalculoGases;
import com.example.domain.ResultadoCalculo;
import com.example.dto.CalculoGasesDTO;
import com.example.dto.ResultadoCalculoDTO;
import com.example.mapper.CalculoGasesMapper;
import com.example.mapper.ResultadoCalculoMapper;
import com.example.mapper.ResultadoCalculoMapperImpl;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CalculoGasesService {

    @Autowired
    private CalculoGasesRepository calculoGasesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ResultadoCalculoRepository resultadoCalculoRepository;
    @Autowired
    private ResultadoCalculoMapperImpl resultadoCalculoMapperImpl;
    @Autowired
    private TipoMetodoRepository tipoMetodoRepository;
    @Autowired
    private TipoCalculoRepository tipoCalculoRepository;
    @Autowired
    private TipoGasesRepository tipoGasesRepository;
    @Autowired
    private TipoMedidaRepository tipoMedidaRepository;
    @Autowired
    private ResultadoCalculoMapper resultadoCalculoMapper;

    public CalculoGasesDTO getCalculoGasesById(Long id) {
        CalculoGases calculoGases = calculoGasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cálculo de Gases no encontrado"));
        return CalculoGasesMapper.INSTANCE.calculoGasesToCalculoGasesDTO(calculoGases);
    }

    public CalculoGasesDTO saveCalculoGases(CalculoGasesDTO calculoGasesDTO) {
        // Verifica que el ID de Usuario no sea nulo
        if (calculoGasesDTO.getUsuarioId() == null) {
            throw new IllegalArgumentException("Usuario ID no debe ser nulo");
        }

        CalculoGases calculoGases = CalculoGasesMapper.INSTANCE.calculoGasesDTOToCalculoGases(calculoGasesDTO);

        // Asegúrate de que el Usuario referenciado exista
        calculoGases.setUsuario(usuarioRepository.findById(calculoGasesDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        calculoGases = calculoGasesRepository.save(calculoGases);
        return CalculoGasesMapper.INSTANCE.calculoGasesToCalculoGasesDTO(calculoGases);
    }

    @Transactional
    public CalculoGasesDTO saveCalculoGasesWithResultados(CalculoGasesDTO calculoGasesDTO) {
        // Verifica que el ID de Usuario no sea nulo
        if (calculoGasesDTO.getUsuarioId() == null) {
            throw new IllegalArgumentException("Usuario ID no debe ser nulo");
        }

        // Mapear y guardar CalculoGases
        CalculoGases calculoGases = CalculoGasesMapper.INSTANCE.calculoGasesDTOToCalculoGases(calculoGasesDTO);
        calculoGases.setUsuario(usuarioRepository.findById(calculoGasesDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        calculoGases = calculoGasesRepository.save(calculoGases);

        // Guardar los ResultadoCalculo asociados
        Set<ResultadoCalculo> resultadosCalculo = new HashSet<>();
        for (ResultadoCalculoDTO resultadoDTO : calculoGasesDTO.getResultados_calculo()) {
            ResultadoCalculo resultadoCalculo = resultadoCalculoMapperImpl.resultadoCalculoDTOToResultadoCalculo(resultadoDTO);

            resultadoCalculo.setCalculo_gases(calculoGases);
            resultadoCalculo.setTipo_metodo(tipoMetodoRepository.findById(resultadoDTO.getTipoMetodoId())
                    .orElseThrow(() -> new RuntimeException("TipoMetodo no encontrado")));
            resultadoCalculo.setTipo_calculo(tipoCalculoRepository.findById(resultadoDTO.getTipoCalculoId())
                    .orElseThrow(() -> new RuntimeException("TipoCalculo no encontrado")));
            resultadoCalculo.setTipo_gases(tipoGasesRepository.findById(resultadoDTO.getTipoGasesId())
                    .orElseThrow(() -> new RuntimeException("TipoGases no encontrado")));
            resultadoCalculo.setTipo_medida(tipoMedidaRepository.findById(resultadoDTO.getTipoMedidaId())
                    .orElseThrow(() -> new RuntimeException("TipoMedida no encontrado")));

            resultadoCalculo = resultadoCalculoRepository.save(resultadoCalculo);
            resultadosCalculo.add(resultadoCalculo);
        }

        // Actualizar la relación en el CalculoGases y guardarlo de nuevo
        calculoGases.setResultados_calculo(resultadosCalculo);
        calculoGases = calculoGasesRepository.save(calculoGases);

        // Devolver el CalculoGasesDTO con los ResultadoCalculo creados
        return CalculoGasesMapper.INSTANCE.calculoGasesToCalculoGasesDTO(calculoGases);
    }


    public void deleteCalculoGases(Long id) {
        calculoGasesRepository.deleteById(id);
    }

    public List<CalculoGasesDTO> getAllCalculoGases() {
        List<CalculoGases> calculoGasesList = calculoGasesRepository.findAll();
        return calculoGasesList.stream()
                .map(CalculoGasesMapper.INSTANCE::calculoGasesToCalculoGasesDTO)
                .collect(Collectors.toList());
    }
}
