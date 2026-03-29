package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Report;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with id: " + id));
    }

    public List<Report> getReportsByScope(String scope) {
        return reportRepository.findByScope(scope);
    }

    public List<Report> getReportsByGeneratedBy(Long userId) {
        return reportRepository.findByGeneratedByFk(userId);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report updateReport(Long id, Report reportDetails) {
        Report report = getReportById(id);
        report.setScope(reportDetails.getScope());
        report.setParametersJson(reportDetails.getParametersJson());
        report.setMetricsJson(reportDetails.getMetricsJson());
        report.setReportUri(reportDetails.getReportUri());
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        Report report = getReportById(id);
        reportRepository.delete(report);
    }
}
