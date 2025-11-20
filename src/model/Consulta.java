package model;

import java.time.LocalDate;

public class Consulta {
    private int idConsulta;
    private int idPet;
    private LocalDate dataConsulta;
    private String motivo;
    private String diagnostico;
    private double valor;
    private String status;
    private int idUsuarioCliente;
    private int idUsuarioVeterinario;


    public Consulta(int idPet, LocalDate dataConsulta, String motivo, String diagnostico,
                    double valor, String status,  int idUsuarioCliente, int idUsuarioVeterinario) {
        this.idPet = idPet;
        this.dataConsulta = dataConsulta;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.valor = valor;
        this.status = status;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idUsuarioVeterinario = idUsuarioVeterinario;
    }

    public Consulta(int idPet, LocalDate dataConsulta, String motivo, String diagnostico,
                    double valor, String status,  int idUsuarioCliente, int idUsuarioVeterinario, int idConsulta) {
        this(idPet, dataConsulta, motivo, diagnostico, valor, status, idUsuarioCliente, idUsuarioVeterinario);
        this.idConsulta = idConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(int idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public int getIdUsuarioVeterinario() {
        return idUsuarioVeterinario;
    }

    public void setIdUsuarioVeterinario(int idUsuarioVeterinario) {
        this.idUsuarioVeterinario = idUsuarioVeterinario;
    }
}
