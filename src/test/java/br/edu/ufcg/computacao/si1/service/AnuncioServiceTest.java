package br.edu.ufcg.computacao.si1.service;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioImovel;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioMovel;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncioServiceTest {

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @Autowired
    private AnuncioRepository anuncioRepository;

    private Anuncio anuncio1, anuncio2, anuncio3;


    @Before
    public void setUp() {
        anuncio1 = new AnuncioMovel("Anuncio de Movel", 100, "movel","user@email.com");
        anuncio2 = new AnuncioImovel("Anuncio de Imovel", 100000, "imovel","user@email.com");
        anuncio3 = new AnuncioEmprego("Anuncio de Emprego", 0, "emprego","user@email.com");
    }

    @After
    public void tearDown() {
        anuncioRepository.deleteAll();
    }

    @Test
    public void testInicializacao() {
        assertNotNull("AnuncioService não foi instânciado corretamente", anuncioService);
        assertTrue("AnuncioService não deveria conter nenhum item", anuncioService.getAll().isEmpty());
    }

/*
    @Test
    public void testCreateAd() {
        Anuncio anuncio1FromDB = anuncioService.cria(anuncio1);
        Anuncio anuncio2FromDB = anuncioService.cria(anuncio2);
        Anuncio anuncio3FromDB = anuncioService.cria(anuncio3);

        assertNotNull(anuncio1FromDB);
        assertNotNull(anuncio2FromDB);
        assertNotNull(anuncio3FromDB);

        assertTrue(anuncioRepository.exists(anuncio1FromDB.getId()));
        assertTrue(anuncioRepository.exists(anuncio2FromDB.getId()));
        assertTrue(anuncioRepository.exists(anuncio3FromDB.getId()));

        assertEquals(anuncio1FromDB, anuncio1);
        assertEquals(anuncio2FromDB, anuncio2);
        assertEquals(anuncio3FromDB, anuncio3);

        assertEquals(anuncio1FromDB, anuncioService.getById(anuncio1FromDB.getId()).get());
        assertEquals(anuncio2FromDB, anuncioService.getById(anuncio2FromDB.getId()).get());
        assertEquals(anuncio3FromDB, anuncioService.getById(anuncio3FromDB.getId()).get());
    }

    @Test
    public void testGetPorTipo() {

        int QTDE_ANUNCIOS_ESPERADA = 1;

        Anuncio anuncioMovel = anuncioService.cria(anuncio1);
        Anuncio anuncioImovel = anuncioService.cria(anuncio2);
        Anuncio anuncioEmprego = anuncioService.cria(anuncio3);

        assertNotNull(anuncioMovel);
        assertNotNull(anuncioImovel);
        assertNotNull(anuncioEmprego);

        assertEquals(anuncioMovel.getTipo(), "movel");
        assertEquals(anuncioImovel.getTipo(), "imovel");
        assertEquals(anuncioEmprego.getTipo(), "emprego");

        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.get("movel").size());
        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.get("imovel").size());
        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.get("emprego").size());

        assertTrue(anuncioService.get("movel").contains(anuncioMovel));
        assertTrue(anuncioService.get("imovel").contains(anuncioImovel));
        assertTrue(anuncioService.get("emprego").contains(anuncioEmprego));
    }

    @Test
    public void testGetAll() {
        int QTDE_ANUNCIOS_ESPERADA = 3;

        Anuncio anuncioMovel = anuncioService.create(anuncio1);
        Anuncio anuncioImovel = anuncioService.create(anuncio2);
        Anuncio anuncioEmprego = anuncioService.create(anuncio3);

        assertNotNull(anuncioMovel);
        assertNotNull(anuncioImovel);
        assertNotNull(anuncioEmprego);

        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.findAll().size());

        assertTrue(anuncioService.findAll().contains(anuncioMovel));
        assertTrue(anuncioService.findAll().contains(anuncioImovel));
        assertTrue(anuncioService.findAll().contains(anuncioEmprego));

    }

    @Test
    public void testDelete() {
        int QTDE_ANUNCIOS_ESPERADA = 3;

        Anuncio anuncioMovel = anuncioService.create(anuncio1);
        Anuncio anuncioImovel = anuncioService.create(anuncio2);
        Anuncio anuncioEmprego = anuncioService.create(anuncio3);

        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.findAll().size());
        assertTrue(anuncioService.findAll().contains(anuncioMovel));
        assertTrue(anuncioService.findAll().contains(anuncioImovel));
        assertTrue(anuncioService.findAll().contains(anuncioEmprego));

        assertTrue(anuncioService.delete(anuncioMovel.getId()));
        QTDE_ANUNCIOS_ESPERADA-=1;
        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.findAll().size());
        assertFalse(anuncioService.findAll().contains(anuncioMovel));
        assertTrue(anuncioService.findAll().contains(anuncioImovel));
        assertTrue(anuncioService.findAll().contains(anuncioEmprego));

        assertTrue(anuncioService.delete(anuncioImovel.getId()));
        QTDE_ANUNCIOS_ESPERADA-=1;
        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.findAll().size());
        assertFalse(anuncioService.findAll().contains(anuncioMovel));
        assertFalse(anuncioService.findAll().contains(anuncioImovel));
        assertTrue(anuncioService.findAll().contains(anuncioEmprego));

        assertTrue(anuncioService.delete(anuncioEmprego.getId()));
        QTDE_ANUNCIOS_ESPERADA-=1;
        assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.findAll().size());
        assertFalse(anuncioService.findAll().contains(anuncioMovel));
        assertFalse(anuncioService.findAll().contains(anuncioImovel));
        assertFalse(anuncioService.findAll().contains(anuncioEmprego));

        assertEquals(0, QTDE_ANUNCIOS_ESPERADA);

        assertFalse(anuncioService.delete(anuncioMovel.getId()));
        assertFalse(anuncioService.delete(anuncioImovel.getId()));
        assertFalse(anuncioService.delete(anuncioEmprego.getId()));
    }

    @Test
    public void testUpdate() {

        String SUFIXO = " editado";

        Anuncio anuncioMovel = anuncioService.create(anuncio1);
        Anuncio anuncioImovel = anuncioService.create(anuncio2);
        Anuncio anuncioEmprego = anuncioService.create(anuncio3);

        assertEquals(anuncioMovel, anuncio1);
        assertEquals(anuncioImovel, anuncio2);
        assertEquals(anuncioEmprego, anuncio3);

        //Update Titulo
        anuncioMovel.setTitulo(anuncioMovel.getTitulo()+SUFIXO);
        anuncioImovel.setTitulo(anuncioImovel.getTitulo()+SUFIXO);
        anuncioEmprego.setTitulo(anuncioEmprego.getTitulo()+SUFIXO);

        assertTrue(anuncioService.update(anuncioMovel));
        assertTrue(anuncioService.update(anuncioImovel));
        assertTrue(anuncioService.update(anuncioEmprego));

        assertEquals(anuncioMovel.getTitulo(), anuncioService.getById(anuncioMovel.getId()).get().getTitulo());
        assertEquals(anuncioImovel.getTitulo(), anuncioService.getById(anuncioImovel.getId()).get().getTitulo());
        assertEquals(anuncioEmprego.getTitulo(), anuncioService.getById(anuncioEmprego.getId()).get().getTitulo());

        //Update preço
        anuncioMovel.setPreco(anuncioMovel.getPreco()*2);
        anuncioImovel.setPreco(anuncioImovel.getPreco()*2);
        anuncioEmprego.setPreco(anuncioEmprego.getPreco()*2);

        assertTrue(anuncioService.update(anuncioMovel));
        assertTrue(anuncioService.update(anuncioImovel));
        assertTrue(anuncioService.update(anuncioEmprego));

        assertEquals(anuncioMovel.getPreco(), anuncioService.getById(anuncioMovel.getId()).get().getPreco());
        assertEquals(anuncioImovel.getPreco(), anuncioService.getById(anuncioImovel.getId()).get().getPreco());
        assertEquals(anuncioEmprego.getPreco(), anuncioService.getById(anuncioEmprego.getId()).get().getPreco());

        assertTrue(anuncioService.update(anuncioMovel));
        assertTrue(anuncioService.update(anuncioImovel));
        assertTrue(anuncioService.update(anuncioEmprego));
    }
*/
}
