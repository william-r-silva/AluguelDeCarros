package com.faraorock.CarroDePrograma;

import com.faraorock.CarroDePrograma.Persistencia.FilialRepository;
import com.faraorock.CarroDePrograma.Persistencia.MecanicaParceiraRepository;
import com.faraorock.CarroDePrograma.Persistencia.CarroRepository;
import com.faraorock.CarroDePrograma.Persistencia.ContratanteRepository;
import com.faraorock.CarroDePrograma.View.FilialViewFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarroDeProgramaApplication {
    
        public static FilialRepository filialRepository;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CarroDeProgramaApplication.class);
        builder.headless(false);
        builder.run(args);
	}
	
	@Bean
	public ContratanteRepository run(ContratanteRepository cr) {
		
		return cr;
	}
	
	@Bean
	public FilialRepository run2(FilialRepository fr) {
            CarroDeProgramaApplication.filialRepository = fr;
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(FilialViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(FilialViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(FilialViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FilialViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                     new FilialViewFrame().setVisible(true);
                }
            });
            
            return fr;
	}

	@Bean
	public CarroRepository run3(CarroRepository car) {
		
		return car;
	}
	
	@Bean
	public MecanicaParceiraRepository run4(MecanicaParceiraRepository mpr) {
		
		return mpr;
	}
}
