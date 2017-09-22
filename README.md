# Sistema-de-Pracas-de-Pedagio

 ================================= INSTRUÇÕES PARA ABRIR O PROJETO JAVA ================================================================
  - Efetue o download e importo-o no eclipse ou netbeans.
  - Todos os direitos reservados 2017.

------------------------------- UNIFAE ENGENHARIA DE SOFTWARE 4°SEMESTRE 2017 ----------------------------------------------------------

Descrição do Trabalho:

Profa. Cristiane Imamura. 
Data de entrega de resolução: 15/09/2017 
Número máximo de alunos por grupo: 3.  
O código fonte (.java): deve ser encaminhado para o e-mail cimamura@gmail.com. Além disso, deve ser entregue uma cópia impressa do código e o diagrama de classes ( por e-mail). 
Conceitos a serem avaliados: encapsulamento, construtores, membros estáticos, associação e herança.  
A resolução correta do trabalho corresponderá a 3 pontos de atividade prática na nota do primeiro bimestre.  
Importante: Para ser analisado, seu código não deve conter erros de compilação, e deve apresentar código documentado (com comentários relevantes). Não deve ser usado API de Coleções. Caso seja verificada cópia do trabalho será dada nota zero a todas as cópias. 
 
Definição do trabalho 
 Em um país distante, os habitantes da cidade Carcity têm sofrido com os freqüentes engarrafamentos causados pela grande frota de veículos que trafega pela cidade. Embora a cidade conte com um sistema de rodízio para evitar maiores transtornos, em alguns horários essa medida não é efetiva quando se considera que, em Carcity, há cerca de 400 carros novos sendo vendidos por dia e que há mais de três milhões de veículos circulando ao mesmo tempo. Para solucionar esse problema o prefeito pretende melhorar o sistema de transporte coletivo. Entretanto, ele precisa arrecadar uma grande soma em dinheiro e, para isso, resolveu implantar praças de pedágio na cidade. Desta forma, o prefeito precisa de um sistema para controlar a quantidade de dinheiro arrecadado com os pedágios. 
No Sistema, para cada praça de pedágio deve ser registrado: o código da praça, o nome da Concessionária, o local onde a praça se encontra, o valor a ser cobrado por um eixo, e as informações de cada veículo que passou pela praça. 
 Os veículos que devem pagar pedágio em Carcity podem ser de duas categorias: 
 • Categoria 1 : Passeio/Utilitário.  
• Categoria 2: Comercial.  
Para os veículos de passeio ou utilitários devem ser registrados: a placa, a data (dia/mês/ano) e o horário (hora/minutos/segundos) em que o veículo passou pela praça.  
Para os veículos comerciais devem ser registrados: a placa, a data (dia/mês/ano), o horário (hora/minutos/segundos) e o número de eixos. Como Carcity possui muitas ruas com trânsito intenso, o prefeito prevê que sejam instaladas diversas praças de pedágio.  
O Sistema, a ser desenvolvido, deverá contar com um menu com as funcionalidades descritas a seguir.  
1. Cadastro de uma praça de pedágio Ao escolher esta opção, o sistema solicita que o usuário informe o nome da Concessionária, o local onde a praça se encontra e o valor a ser cobrado por um eixo. O código não deve ser informado pelo usuário, portanto, seu sistema deve gerá-lo, e deve garantir que não haja códigos repetidos. As informações lidas devem ser armazenadas em um objeto guardado em um vetor em uma classe adequada ( que não faça parte do view).  2. Cadastro de um Veículo Categoria 1 na praça de pedágio Ao escolher esta opção, o sistema solicita que o usuário informe o código da praça de pedágio. Caso o código seja inválido uma mensagem apropriada deve ser impressa. No caso do código ser encontrado, são lidas as informações a serem registradas para o veículo de Categoria 1 e estes dados são armazenados em um objeto guardado em um vetor contido na praça de pedágio.  3. Cadastro de um Veículo Categoria 2 na praça de pedágio  Ao escolher esta opção, o sistema solicita que o usuário informe o código da praça de pedágio. Caso o código seja inválido uma mensagem apropriada deve ser impressa. No caso do código ser encontrado, são lidas as informações a serem registradas para o veículo de Categoria 2 e estes dados são armazenados em um objeto guardado em um vetor contido na praça de pedágio.  4. Faturamento para Prefeitura  Ao escolher esta opção, o sistema deve gerar um relatório com o seguinte formato para cada praça de pedágio instalada na cidade. ____________________________________________________________________ Praça de Pedágio  Código:                                        Local:  _____________________________________________________________________ 
 
Veículos de Categoria 1    Placa:             data:  /  /           horário:   /  /          valorpago:  Placa:            data:  /  /            horário:   /  /          valorpago:  (...)     ____________________________________________________________________ Veículos de  Categoria 2    Placa:     data:     /   /    horário:  /  /    valorpago:  Placa:     data:    /  /      horário:  /  /    valorpago:  (...)  
____________________________________________________________________  Total arrecadado na praça: 
 
 
 O valor a ser pago por um veículo da categoria 1 é o valor de um eixo. Enquanto que para a categoria 2, o valor a ser pago é o valor do eixo multiplicado pelo número de eixos.    Ao final da impressão do relatório de cada praça, deve ser impressa a soma total dos valores arrecadados em todas as praças, e o valor a ser recebido pela prefeitura.    O valor a ser recebido pela prefeitura é igual 30% da soma total. 
 
5. Consulta de registros por veículo Ao escolher essa opção, o sistema deve solicitar a placa do veículo a ser consultado. Caso o código seja inválido uma mensagem apropriada deve ser impressa. No caso do código ser encontrado, o sistema deve imprimir as informações de data e horário que o veículo foi registrado em cada praça de pedágio existente. 
