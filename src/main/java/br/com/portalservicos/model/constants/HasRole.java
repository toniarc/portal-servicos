package br.com.portalservicos.model.constants;

public class HasRole {

    public static final String OR = " or ";
    public static final String ADMINISTRADOR_SISTEMA = "hasRole('"+ Role.ADMINISTRADOR_SISTEMA +"')";
    public static final String ANALISTA_CONTAS = "hasRole('"+ Role.ANALISTA_CONTAS +"')";
    public static final String ANALISTA_NEGOCIO = "hasRole('"+ Role.ANALISTA_NEGOCIO +"')";
    public static final String ANALISTA_RISCO_CREDITO = "hasRole('"+ Role.ANALISTA_RISCO_CREDITO +"')";
    public static final String ADMINSTRADOR_EMPRESA_FORNECEDORA = "hasRole('"+ Role.ADMINSTRADOR_EMPRESA_FORNECEDORA +"')";
    public static final String ADMINSTRADOR_EMPRESA_CONTRATANTE = "hasRole('"+ Role.ADMINSTRADOR_EMPRESA_CONTRATANTE +"')";


    public static final String PERFIL_LISTAR = "hasRole('"+ Role.PERFIL_LISTAR +"')";
    public static final String OPERACAO_PERFIL_LISTAR = "hasRole('"+ Role.OPERACAO_PERFIL_LISTAR +"')";
    public static final String OPERACAO_LISTAR = "hasRole('"+ Role.OPERACAO_LISTAR +"')";
    public static final String PERMISSAO_PERFIL_LISTAR = "hasRole('"+ Role.PERMISSAO_PERFIL_LISTAR +"')";
    public static final String AUDITOR = "hasRole('"+ Role.AUDITOR +"')";
}
