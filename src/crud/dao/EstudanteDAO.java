package crud.dao;

import java.util.List;





import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.Estudante;

import crud.util.HibernateUtil;

public class EstudanteDAO {

	public void saveEstudante(Estudante estudante) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Inicio da a transacao
			transaction = session.beginTransaction();
			// salvar o objecto de estudante 
			session.save(estudante);
			// commit transacao
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Estudante
	 * @param user
	 */
	public void updateEstudante(Estudante estudante) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// inicio da a transacao
			transaction = session.beginTransaction();
			// salvar o objecto de estudante
			session.update(estudante);
			// commit transacao
			transaction.commit();
		
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Estudante
	 * @param id
	 */
	public void deleteEstudante(int numero_matricula) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// inicio da a transacao
			transaction = session.beginTransaction();

			// Eliminar um objecto de estudante
			Estudante estudante = session.get(Estudante.class, numero_matricula);
			if (estudante != null) {
				session.delete(estudante);
				System.out.println("Estudante eliminado com sucesso!!!");
			}

			// commit transacao
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Busca Estudante por numero_matricula
	 * @param numero_matricula
	 * @return
	 */
	public Estudante getEstudante(int numero_matricula) {

		Transaction transaction = null;
		Estudante estudante = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// inicia uma transacao
			transaction = session.beginTransaction();
			// busca varios objectos de estudantes
			estudante = session.get(Estudante.class, numero_matricula);
			// commit transacao
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return estudante;
	}
	
	/**
	 * Busca todos Estudantes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Estudante> getAllEstudante() {

		Transaction transaction = null;
		List<Estudante> listOfEstudante = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// inicia uma transacao
			transaction = session.beginTransaction();
			// busca varios objectos de estudante
			
			listOfEstudante = session.createQuery("from Estudante").getResultList();//temos que referencia a nossa classe Estudante
			
			// commit transacao
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfEstudante;
	}

}
