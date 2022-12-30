#language: pt

@login @e2e
Funcionalidade: Login

  @login-tabela
  Esquema do Cenário: Realizar login utilizando Tabela
    Dado que faça login utilizando: "<email>" Senha: "<senha>"
    Então estou logado no app

    Exemplos:'
      | email        | senha   |
      | eu@papito.io   | qaninja |
