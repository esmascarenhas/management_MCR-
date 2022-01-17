
# Project-management MCR 


<p><strong>Projeto desenvolvido no Bootcamp: GFT Start #3 Java <strong> - Explorando Padrões de Projetos na Prática com Java</strong>.
Desafio que pude desenvolver uma api seguindo alguns Design Patterns:  <strong> Singleton, Strategy e Facade.




<h2>
 🧮 Framework utilizados
</h2>

- [x] Java JDK 11
- [x] IDE IntelliJ
- [x] Documentação e consumo no Swagger
- [x] Banco de Dados MySQL
- [x] Estrutura - spring initializr 

<ul>
<h2> ✨ Desafio</h2>

🔸 <strong> Visão geral:  Sistema de cadastro de unidades (apartamentos) em um condominio e o controle de entrega, além do registro de ocorrências </strong>


</ul>
	  
	  
<ul>
	 👣 Solução
  
    🔻 Padrão Singleton - garantir que uma classe tenha apenas uma instância de si mesma e que forneça um ponto global de acesso a ela:
                 🔹 Utilização de anotações @Bean e @Autowired ;
	  🔻 Padrão Strategy - Criar uma Estratégia para cada variante e faz com que o método delegue o algoritmo para uma instância de Estratégia:
                 🔹 Utilização de anotações @Service e @Repository ;
	  🔻 Padrão Faced - diminue a complexidade geral do aplicativo:
                 🔹 Criação de uma API para abstrair a complexidade do back end e repositorio para o usuário do condominio.
    

</ul>
	
🔸 <strong> Security </strong><br>
	  Utilização do JWT para geração e validação de token para autenticação.<br>
	  Spring Security para solução de segurança<br>
	  Autenticação de usuario e senha via Banco de dados<br>
	  
  <p><strong>🔗No Controlador de acesso:<br>
<br>
	
	🔻 Realiza o metodo post, utilizando o username e a senha do usuário;
	🔻 Cadastrado, no Banco, dois usuários para teste:
	       Perfil ADMIN: Username (Admin) senha (123456)
	       Perfil User: Username (Usuario) senha (654321)
	🔻 Executando o metodo post, recebe o token e cadastra no autorizador (Cadeaddo no canto superior direito);
	🔻 Pronto! Você está autorizado para utilizar os serviços que possui autenticação liberada(conforme consta na descrição de cada metodo.
	
</br>
  
    
    
------------
Disponibilizado por [Emerson](https://www.linkedin.com/in/emerson-mascarenhas-86b8462b).
