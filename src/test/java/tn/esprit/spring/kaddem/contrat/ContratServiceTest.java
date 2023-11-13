package tn.esprit.spring.kaddem.contrat;
/*package tn.esprit.spring.kaddem.contrat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContratServiceTest {

    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;

    @Test
    public void testAddContrat() {
        // Création d'un objet Contrat de test
        Contrat contrat = new Contrat(new Date(2023, 10, 1), new Date(2023, 10, 31), Specialite.IA, false, 5000);

        when(contratRepository.save(contrat)).thenReturn(contrat);

        Contrat result = contratService.addContrat(contrat);

        // Vérification que la méthode save a été appelée une fois avec le contrat en argument
        verify(contratRepository).save(contrat);

        // Vérification du résultat
        assertEquals(contrat, result);
    }
}*/
/*_____________________________________________________________________________*/
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContratServiceTest {

    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;

    @Test
    public void testRetrieveAllContrats() {
        Contrat contrat1 = new Contrat(); // Créez des contrats fictifs pour les tests
        Contrat contrat2 = new Contrat();
        List<Contrat> mockContrats = Arrays.asList(contrat1, contrat2);

        when(contratRepository.findAll()).thenReturn(mockContrats);

        List<Contrat> result = contratService.retrieveAllContrats();

        verify(contratRepository).findAll(); // Vérifie si la méthode findAll a été appelée

        assertEquals(2, result.size()); // Vérifie le nombre d'éléments retournés
        assertEquals(mockContrats, result); // Vérifie si la liste retournée correspond à celle attendue
    }

    @Test
    public void testUpdateContrat() {
        Contrat contrat = new Contrat();
        when(contratRepository.save(contrat)).thenReturn(contrat);

        Contrat result = contratService.updateContrat(contrat);

        verify(contratRepository).save(contrat); // Vérifie si la méthode save a été appelée

        assertEquals(contrat, result); // Vérifie si le contrat retourné est celui attendu
    }

    @Test
    public void testAddContrat() {
        Contrat contrat = new Contrat();
        when(contratRepository.save(contrat)).thenReturn(contrat);

        Contrat result = contratService.addContrat(contrat);

        verify(contratRepository).save(contrat); // Vérifie si la méthode save a été appelée

        assertEquals(contrat, result); // Vérifie si le contrat retourné est celui attendu
    }

    @Test
    public void testRetrieveContrat() {
        Contrat contrat = new Contrat();
        int idContrat = 1;

        when(contratRepository.findById(idContrat)).thenReturn(Optional.of(contrat));

        Contrat result = contratService.retrieveContrat(idContrat);

        verify(contratRepository).findById(idContrat); // Vérifie si la méthode findById a été appelée

        assertEquals(contrat, result); // Vérifie si le contrat retourné est celui attendu
    }

    @Test
    public void testRemoveContrat() {
        Contrat contrat = new Contrat();
        int idContrat = 1;

        when(contratRepository.findById(idContrat)).thenReturn(Optional.of(contrat));

        contratService.removeContrat(idContrat);

        verify(contratRepository).findById(idContrat); // Vérifie si la méthode findById a été appelée
        verify(contratRepository).delete(contrat); // Vérifie si la méthode delete a été appelée avec le contrat
    }
}

