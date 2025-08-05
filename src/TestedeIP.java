import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class TestedeIP {
	public static void main (String[] args) {
		while(true) {
		try {
			//Informações do Endereço IP
			InetAddress localHost = InetAddress.getLocalHost();
			String nomeServidor = localHost.getHostName();
			LocalDateTime inicioOnline = null;
			
			//Arranjar informações de tempo 
			//(PARTE FEITA INTEIRAMENTE COM CHATGPT POIS NÃO ACHAVA COMO FAZER NA INTERNET)
			 String ultimaVezOnline = "Nunca"; //Pelo que entendi esse valor seria o valor inicial 
			 //para caso o IP esteja offline na hora de testar
			
			 LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String dataEHoraPing = LocalDateTime.now().format(formatter);
			//Fim da parte feita com GPT
			
			//Checando se a variavel inicioOnline vai arranjar uma variavel ou não
			if (inicioOnline == null) {
                inicioOnline = agora;
            }
			
			 // Calcula tempo de atividade
            Duration uptime = Duration.between(inicioOnline, agora);
            long minutos = uptime.toMinutes();
            long segundos = uptime.getSeconds() % 60;
            
			if(InetAddress.getByName("127.0.0.1").isReachable(5000)) {
				System.out.println("Conexão: Ok");
				
					ultimaVezOnline = dataEHoraPing; // atualiza a última vez online
				
					System.out.println("Ultima vez Online:" + ultimaVezOnline);
				
					InetAddress endereçoIP = InetAddress.getLocalHost();
				
					System.out.println("Nome do Servidor: " + nomeServidor);
	            
					System.out.println("Endereço IP Local: " + endereçoIP.getHostAddress());
	            
					System.out.println("Data e hora do ping: " + dataEHoraPing);
					
					System.out.println("Tempo de atividade: " + minutos + " minutos e " + segundos + " segundos");
					
					System.out.println(endereçoIP);
					}
			
			else {
				System.out.println("Última vez online: " + ultimaVezOnline);
                System.out.println("Hora atual da falha: " + dataEHoraPing);
                System.out.println("Tempo de atividade anterior foi encerrado.");
                System.out.println("---------------------------------------------");

			}
			
				
				Thread.sleep(1000);		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Erro no try");
		}
	}
}
}
