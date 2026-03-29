package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.KPI;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.KpiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KpiService {

    private final KpiRepository kpiRepository;

    public KPI createKpi(KPI kpi) {
        return kpiRepository.save(kpi);
    }

    public KPI getKpiById(Long id) {
        return kpiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KPI not found with id: " + id));
    }

    public KPI getKpiByName(String name) {
        return kpiRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("KPI not found with name: " + name));
    }

    public List<KPI> getKpisByPeriod(String period) {
        return kpiRepository.findByReportingPeriod(period);
    }

    public List<KPI> getAllKpis() {
        return kpiRepository.findAll();
    }

    public KPI updateKpi(Long id, KPI kpiDetails) {
        KPI kpi = getKpiById(id);
        kpi.setName(kpiDetails.getName());
        kpi.setDefinition(kpiDetails.getDefinition());
        kpi.setTargetValue(kpiDetails.getTargetValue());
        kpi.setCurrentValue(kpiDetails.getCurrentValue());
        kpi.setReportingPeriod(kpiDetails.getReportingPeriod());
        return kpiRepository.save(kpi);
    }

    public void deleteKpi(Long id) {
        KPI kpi = getKpiById(id);
        kpiRepository.delete(kpi);
    }
}
