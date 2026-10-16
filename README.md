# Carteirinha Digital — 2DEVEST_B

[![Android](https://img.shields.io/badge/Android-Jetpack%20Compose-green.svg)](https://developer.android.com/jetpack/compose)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.2-blue.svg)](https://kotlinlang.org/)
[![Backend](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen.svg)](https://spring.io/projects/spring-boot)

Projeto de estudo e desenvolvimento da **Carteirinha Digital**, desenvolvido por **Eduardo dos Santos Correia** (**Eduardo Santos**). O sistema permite o acesso dos alunos à sua carteirinha estudantil digital, gerando um QR Code de validação e permitindo o acompanhamento do desempenho nas Unidades Curriculares (notas e faltas).

---

## 📱 Visão Geral do Sistema

O projeto é composto por dois módulos principais:
1. **Aplicativo Mobile (Android)**: Interface moderna em **Jetpack Compose** com suporte a Light/Dark Theme, navegação reativa (`Navigation Compose`), visualização de perfil de aluno, QR Code e consulta de notas.
2. **API Backend (`backend-api`)**: Serviço RESTful em **Java 21 / Spring Boot 3** implementando autenticação segura via **JWT** e criptografia de senhas com **BCrypt**, seguindo princípios de Clean Architecture e Monólito Modular.

---

## 🛠️ Tecnologias Utilizadas

### Aplicativo Android
- **Linguagem**: Kotlin 2.2
- **UI Framework**: Jetpack Compose com Material Design 3
- **Arquitetura**: MVI / MVVM com Clean Architecture (Feature-based)
- **Navegação**: Navigation Compose
- **Injeção de Dependências**: Manual / Container Pattern (`AppContainer`)
- **Comunicação de Rede**: Retrofit2 + OkHttp3 + Kotlinx Serialization
- **Geração de QR Code**: Google ZXing Library

### Backend (`backend-api`)
- **Linguagem**: Java 21
- **Framework**: Spring Boot 3.5.16 (Web, Data JPA, Security)
- **Segurança & Autenticação**: Spring Security + BCrypt + JWT (HMAC SHA-256)
- **Banco de Dados**: H2 (em memória) / Suporte a PostgreSQL
- **Documentação da API**: Swagger / OpenAPI 3

---

## 🚀 Como Executar o Projeto

### 1. Executando o Aplicativo Android
1. Abra a pasta do projeto no **Android Studio**.
2. Aguarde a sincronização do **Gradle** (`Sync Project with Gradle Files`).
3. Selecione um dispositivo emulador ou aparelho físico Android (API 24+ / Android 7.0+).
4. Execute o aplicativo pressionando `Run` (`Shift + F10`).

> **Nota sobre Modo Offline / Backend**:
> Por padrão, o aplicativo está configurado com `USE_FAKE_REPOSITORY = true` no `DefaultAppContainer`, permitindo testar todas as telas e fluxos diretamente no emulador sem necessidade do backend.
> Para conectar à API real, altere a constante `USE_FAKE_REPOSITORY = false` em `DefaultAppContainer.kt`.

### 2. Executando o Backend (`backend-api`)
Requisitos: JDK 21+ e Maven 3.6+

```bash
cd backend-api
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.
A documentação Swagger pode ser acessada em `http://localhost:8080/swagger-ui.html`.

#### Credenciais Padrão de Teste:
- **Usuário**: `aluno`
- **Senha**: `123`
- **Nome do Aluno**: Eduardo dos Santos Correia

---

## 📋 Instruções para Versionamento no GitHub

Para publicar este projeto em seu repositório pessoal:

```bash
# 1. Inicializar o repositório git (caso ainda não inicializado)
git init

# 2. Adicionar os arquivos ao staging
git add .

# 3. Criar o commit inicial
git commit -m "feat: inicializacao do projeto Carteirinha Digital personalizado por Eduardo Santos"

# 4. Vincular ao seu repositório remoto no GitHub
git remote add origin https://github.com/SEU_USUARIO/CarteirinhaDigital_EduardoSantos.git

# 5. Enviar para a branch principal
git branch -M main
git push -u origin main
```

---

## 📄 Créditos e Licença

Projeto desenvolvido como parte do curso de Desenvolvimento de Sistemas no SENAI, adaptado e personalizado por **Eduardo dos Santos Correia** para fins de estudo e portfólio.
