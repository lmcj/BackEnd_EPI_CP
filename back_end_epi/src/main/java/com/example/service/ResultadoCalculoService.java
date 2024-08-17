package com.example.service;

import com.example.domain.ResultadoCalculo;
import com.example.dto.ResultadoCalculoDTO;
import com.example.mapper.ResultadoCalculoMapper;
import com.example.repository.CalculoGasesRepository;
import com.example.repository.TipoCalculoRepository;
import com.example.repository.ResultadoCalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultadoCalculoService {

    @Autowired
    private ResultadoCalculoRepository resultadoCalculoRepository;

    @Autowired
    private CalculoGasesRepository calculoGasesRepository;

    @Autowired
    private TipoCalculoRepository tipoCalculoRepository;

    public ResultadoCalculoDTO getResultadoCalculoById(Long id) {
        ResultadoCalculo resultadoCalculo = resultadoCalculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resultado de Cálculo no encontrado"));
        return ResultadoCalculoMapper.INSTANCE.resultadoCalculoToResultadoCalculoDTO(resultadoCalculo);
    }

    public ResultadoCalculoDTO saveResultadoCalculo(ResultadoCalculoDTO resultadoCalculoDTO) {
        // Verifica que los IDs no sean nulos
        if (resultadoCalculoDTO.getCalculoGasesId() == null || resultadoCalculoDTO.getTipoCalculoId() == null) {
            throw new IllegalArgumentException("Cálculo de Gases ID y Tipo de Cálculo ID no deben ser nulos");
        }

        ResultadoCalculo resultadoCalculo = ResultadoCalculoMapper.INSTANCE.resultadoCalculoDTOToResultadoCalculo(resultadoCalculoDTO);

        // Asegúrate de que las entidades referenciadas existan
        resultadoCalculo.setCalculo_gases(calculoGasesRepository.findById(resultadoCalculoDTO.getCalculoGasesId())
                .orElseThrow(() -> new RuntimeException("Cálculo de Gases no encontrado")));
        resultadoCalculo.setTipo_calculo(tipoCalculoRepository.findById(resultadoCalculoDTO.getTipoCalculoId())
                .orElseThrow(() -> new RuntimeException("Tipo de Cálculo no encontrado")));

        resultadoCalculo = resultadoCalculoRepository.save(resultadoCalculo);
        return ResultadoCalculoMapper.INSTANCE.resultadoCalculoToResultadoCalculoDTO(resultadoCalculo);
    }

    public void deleteResultadoCalculo(Long id) {
        resultadoCalculoRepository.deleteById(id);
    }

    public List<ResultadoCalculoDTO> getAllResultadosCalculo() {
        List<ResultadoCalculo> resultadosCalculo = resultadoCalculoRepository.findAll();
        return resultadosCalculo.stream()
                .map(ResultadoCalculoMapper.INSTANCE::resultadoCalculoToResultadoCalculoDTO)
                .collect(Collectors.toList());
    }
}
