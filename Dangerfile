detekt_report_path = "build/reports/detekt/detekt.txt"

if File.exist?(detekt_report_path)
  detekt_report = File.read(detekt_report_path)

  if detekt_report.include?("Finding") || detekt_report.include?("detekt")
    warn("⚠️ Detekt encontrou problemas:\n\n```\n#{detekt_report[0..500]}\n```")
  else
    message("✅ Nenhum problema encontrado pelo Detekt.")
  end
else
  message("⚠️ Relatório do Detekt não encontrado em: #{detekt_report_path}")
end
