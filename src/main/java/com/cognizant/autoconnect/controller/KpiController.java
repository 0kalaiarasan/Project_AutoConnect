package com.cognizant.autoconnect.controller;

import com.cognizant.autoconnect.entity.KPI;
import com.cognizant.autoconnect.service.KpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kpis")
@RequiredArgsConstructor
public class KpiController {

    private final KpiService kpiService;

    @PostMapping
    public ResponseEntity<KPI> createKpi(@RequestBody KPI kpi) {
        return new ResponseEntity<>(kpiService.createKpi(kpi), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KPI> getKpiById(@PathVariable Long id) {
        return ResponseEntity.ok(kpiService.getKpiById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<KPI> getKpiByName(@PathVariable String name) {
        return ResponseEntity.ok(kpiService.getKpiByName(name));
    }

    @GetMapping
    public ResponseEntity<List<KPI>> getAllKpis() {
        return ResponseEntity.ok(kpiService.getAllKpis());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KPI> updateKpi(@PathVariable Long id, @RequestBody KPI kpi) {
        return ResponseEntity.ok(kpiService.updateKpi(id, kpi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKpi(@PathVariable Long id) {
        kpiService.deleteKpi(id);
        return ResponseEntity.noContent().build();
    }
}
