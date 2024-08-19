package com.example.service;

import com.example.domain.ResultadoCalculo;
import com.example.dto.ResultadoCalculoDTO;
import com.example.mapper.ResultadoCalculoMapper;
import com.example.repository.*;
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

    @Autowired
    private TipoGasesRepository tipoGasesRepository;

    @Autowired
    private TipoMedidaRepository tipoMedidaRepository;

    @Autowired
    private TipoMetodoRepository tipoMetodoRepository;

    public ResultadoCalculoDTO getResultadoCalculoById(Long id) {
        ResultadoCalculo resultadoCalculo = resultadoCalculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resultado de Cálculo no encontrado"));
        return ResultadoCalculoMapper.INSTANCE.resultadoCalculoToResultadoCalculoDTO(resultadoCalculo);
    }

    public ResultadoCalculoDTO saveResultadoCalculo(ResultadoCalculoDTO resultadoCalculoDTO) {
        // Verifica que los IDs no sean nulos
        if (resultadoCalculoDTO.getCalculoGasesId() == null ||
                resultadoCalculoDTO.getTipoCalculoId() == null ||
                resultadoCalculoDTO.getTipoGasesId() == null ||
                resultadoCalculoDTO.getTipoMedidaId() == null ||
                resultadoCalculoDTO.getTipoMetodoId() == null) {
            throw new IllegalArgumentException("IDs de las entidades relacionadas no deben ser nulos");
        }

        ResultadoCalculo resultadoCalculo = ResultadoCalculoMapper.INSTANCE.resultadoCalculoDTOToResultadoCalculo(resultadoCalculoDTO);

        // Asegúrate de que las entidades referenciadas existan
        resultadoCalculo.setCalculo_gases(calculoGasesRepository.findById(resultadoCalculoDTO.getCalculoGasesId())
                .orElseThrow(() -> new RuntimeException("Cálculo de Gases no encontrado")));
        resultadoCalculo.setTipo_calculo(tipoCalculoRepository.findById(resultadoCalculoDTO.getTipoCalculoId())
                .orElseThrow(() -> new RuntimeException("Tipo de Cálculo no encontrado")));
        resultadoCalculo.setTipo_gases(tipoGasesRepository.findById(resultadoCalculoDTO.getTipoGasesId())
                .orElseThrow(() -> new RuntimeException("Tipo de Gases no encontrado")));
        resultadoCalculo.setTipo_medida(tipoMedidaRepository.findById(resultadoCalculoDTO.getTipoMedidaId())
                .orElseThrow(() -> new RuntimeException("Tipo de Medida no encontrado")));
        resultadoCalculo.setTipo_metodo(tipoMetodoRepository.findById(resultadoCalculoDTO.getTipoMetodoId())
                .orElseThrow(() -> new RuntimeException("Tipo de Método no encontrado")));

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
