package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import principal.emprestimo.Emprestimo;
import principal.emprestimo.EmprestimoController;
import principal.emprestimo.IdEmprestimo;
import principal.item.Item;
import principal.item.ItemController;
import principal.user.IdUsuario;
import principal.user.UserController;
import principal.user.Usuario;

/**
 * Classe responsavel por salvar os dados da execucao atual e carregar os dados
 * de execucoes passadas.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Persistencia {

	/**
	 * Salva os dados da atual execucao na memoria da maquina para que possam ser
	 * usadas em execucoes futuras.
	 * 
	 * @param usuarios
	 *            o mapa de usuarios que foram cadastrado no sistema.
	 * @param itens
	 *            o mapa dos itens que foram cadastrados no sistema.
	 * @param emprestimos
	 *            o mapa de emprestimos que foram cadastrados no sistema.
	 */
	public void salvar(Map<IdUsuario, Usuario> usuarios, Map<String, Item> itens,
			Map<IdEmprestimo, Emprestimo> emprestimos) {
		try {
			FileOutputStream fos = new FileOutputStream("dados.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(usuarios);
			oos.writeObject(itens);
			oos.writeObject(emprestimos);

			oos.close();
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Carrega os dados de execucoes passadas para a atual execucao do programa.
	 * Cada controlador executa um setData a partir da leituras dos objetos
	 * armazenadas nas execucoes passadas.
	 * 
	 * @param uc
	 *            controlador de usuarios.
	 * @param ic
	 *            controlador de itens.
	 * @param ec
	 *            controlador de emprestimos.
	 */
	@SuppressWarnings("unchecked")
	public void carregar(UserController uc, ItemController ic, EmprestimoController ec) {
		ObjectInputStream ois = null;
		try {
			if (!new File("dados.txt").exists()) {
				FileOutputStream fos = new FileOutputStream("dados.txt");
				fos.close();
			}

			FileInputStream fis = new FileInputStream("dados.txt");

			if (fis.available() > 0) {
				ois = new ObjectInputStream(fis);
				uc.setData((Map<IdUsuario, Usuario>) ois.readObject());
				ic.setData((Map<String, Item>) ois.readObject());
				ec.setData((Map<IdEmprestimo, Emprestimo>) ois.readObject());
				ois.close();
			}

		} catch (IOException | ClassNotFoundException ioecnfe) {
			ioecnfe.printStackTrace();
		}

	}

}
