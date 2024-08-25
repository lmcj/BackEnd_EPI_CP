package com.example.service;

import com.example.domain.CalculoGases;
import com.example.domain.ResultadoCalculo;
import com.example.dto.CalculoGasesDTO;
import com.example.dto.GrupoResultadosCalculoDTO;
import com.example.dto.ResultadoSimplificadoDTO;
import com.example.mapper.CalculoGasesMapper;
import com.example.mapper.ResultadoCalculoMapper;
import com.example.repository.CalculoGasesRepository;
import com.example.repository.ResultadoCalculoRepository;
import com.example.repository.TipoCalculoRepository;
import com.example.repository.TipoGasesRepository;
import com.example.repository.TipoMedidaRepository;
import com.example.repository.TipoMetodoRepository;
import com.example.repository.UsuarioRepository;
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
    private ResultadoCalculoMapper resultadoCalculoMapper;

    @Autowired
    private TipoMetodoRepository tipoMetodoRepository;

    @Autowired
    private TipoCalculoRepository tipoCalculoRepository;

    @Autowired
    private TipoGasesRepository tipoGasesRepository;

    @Autowired
    private TipoMedidaRepository tipoMedidaRepository;

    @Transactional
    public CalculoGasesDTO saveCalculoGasesWithGrupos(CalculoGasesDTO calculoGasesDTO) {
        if (calculoGasesDTO.getUsuarioId() == null) {
            throw new IllegalArgumentException("Usuario ID no debe ser nulo");
        }

        // Guardar CalculoGases
        CalculoGases calculoGases = CalculoGasesMapper.INSTANCE.calculoGasesDTOToCalculoGases(calculoGasesDTO);
        calculoGases.setUsuario(usuarioRepository.findById(calculoGasesDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        calculoGases = calculoGasesRepository.save(calculoGases);

        // Guardar cada grupo de resultados
        Set<ResultadoCalculo> resultadosCalculo = new HashSet<>();
        for (GrupoResultadosCalculoDTO grupo : calculoGasesDTO.getGrupos_resultados()) {
            double iterador = 1;

            for (ResultadoSimplificadoDTO resultadoSimplificado : grupo.getResultados()) {
                ResultadoCalculo resultadoCalculo = new ResultadoCalculo();

                // Asignar los IDs de los tipos
                resultadoCalculo.setTipo_metodo(tipoMetodoRepository.findById(grupo.getTipoMetodoId())
                        .orElseThrow(() -> new RuntimeException("TipoMetodo no encontrado")));
                resultadoCalculo.setTipo_calculo(tipoCalculoRepository.findById(grupo.getTipoCalculoId())
                        .orElseThrow(() -> new RuntimeException("TipoCalculo no encontrado")));
                resultadoCalculo.setTipo_gases(tipoGasesRepository.findById(grupo.getTipoGasesId())
                        .orElseThrow(() -> new RuntimeException("TipoGases no encontrado")));
                resultadoCalculo.setTipo_medida(tipoMedidaRepository.findById(grupo.getTipoMedidaId())
                        .orElseThrow(() -> new RuntimeException("TipoMedida no encontrado")));

                // Asignar el CalculoGases y otros valores
                resultadoCalculo.setCalculo_gases(calculoGases);
                resultadoCalculo.setIterador(iterador);
                resultadoCalculo.setAnio(resultadoSimplificado.getAnio());
                resultadoCalculo.setResultado(resultadoSimplificado.getResultado());

                // Guardar el ResultadoCalculo
                resultadoCalculo = resultadoCalculoRepository.save(resultadoCalculo);
                resultadosCalculo.add(resultadoCalculo);

                iterador++;
            }
        }

        // Actualizar la relación en el CalculoGases y guardarlo de nuevo
        calculoGases.setResultados_calculo(resultadosCalculo);
        calculoGases = calculoGasesRepository.save(calculoGases);

        return CalculoGasesMapper.INSTANCE.calculoGasesToCalculoGasesDTO(calculoGases);
    }

    public CalculoGasesDTO getCalculoGasesById(Long id) {
        CalculoGases calculoGases = calculoGasesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cálculo de Gases no encontrado"));
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
