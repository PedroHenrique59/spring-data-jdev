import org.dao.InterfaceSpringDataUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.model.UsuarioSpringData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    public void testeInsert() {
        UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
        usuarioSpringData.setNome("Joao");
        usuarioSpringData.setEmail("joao@gmail.com");
        usuarioSpringData.setIdade(15);
        usuarioSpringData.setLogin("joao");
        usuarioSpringData.setSenha("123");
        interfaceSpringDataUser.save(usuarioSpringData);
    }

    @Test
    public void findByIdTest() {
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        System.out.println(usuarioSpringData.orElse(null));
    }

    @Test
    public void findAllTest() {
       Iterable<UsuarioSpringData> usuarios = interfaceSpringDataUser.findAll();
       usuarios.forEach(System.out::println);
    }

    @Test
    public void updateTest() {
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
        UsuarioSpringData usuarioUpdate = usuarioSpringData.orElseGet(UsuarioSpringData::new);
        usuarioUpdate.setNome("Pedro Alterado");
        interfaceSpringDataUser.save(usuarioUpdate);
    }

    @Test
    public void deleteTest() {
        Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
        interfaceSpringDataUser.delete(usuarioSpringData.orElse(new UsuarioSpringData()));
    }

    @Test
    public void obterPorNomeTest() {
        List<UsuarioSpringData> usuarios = interfaceSpringDataUser.obterPorNome("Pedro");
        usuarios.forEach(System.out::println);
    }

    @Test
    public void obterPorNomeParamTest() {
        List<UsuarioSpringData> usuarios = interfaceSpringDataUser.obterPorNomeParam("o");
        usuarios.forEach(System.out::println);
    }

    @Test
    public void excluirPorNomeTest() {
        interfaceSpringDataUser.excluirPorNome("Pedro");
    }

}
