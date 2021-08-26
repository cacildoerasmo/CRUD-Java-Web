package crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.Turma;
import crud.util.HibernateUtil;
import crud.util.HibernateUtilTurma;

public class TurmaDAO {
	
	public void saveTurma(Turma turma) {
		Transaction transaction = null;
		try (Session session = HibernateUtilTurma.getSessionFactory1().openSession()) {
			// Inicio da a transacao
			transaction = session.beginTransaction();
			// salvar o objecto de turma
			session.save(turma);
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
	 * Update Turma
	 * @param user
	 */
	public void updateTurma(Turma turma) {
		Transaction transaction = null;
		try (Session session = HibernateUtilTurma.getSessionFactory1().openSession()) {
			// inicio da a transacao
			transaction = session.beginTransaction();
			// salvar o objecto de turma
			session.update(turma);
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
	 * Delete Turma
	 * @param id
	 */
	public void deleteTurma(int identificacao) {

		Transaction transaction = null;
		try (Session session = HibernateUtilTurma.getSessionFactory1().openSession()) {
			// inicio da a transacao
			transaction = session.beginTransaction();

			// Eliminar um objecto de turma
			Turma turma = session.get(Turma.class, identificacao);
			if (turma != null) {
				session.delete(turma);
				System.out.println("Turma eliminado com sucesso!!!");
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
	 * Busca Turma por identificacao
	 * @param numero_matricula
	 * @return
	 */
	public Turma getTurma(int identificacao) {

		Transaction transaction = null;
		Turma estudante = null;
		try (Session session = HibernateUtilTurma.getSessionFactory1().openSession()) {
			// inicia uma transacao
			transaction = session.beginTransaction();
			// busca varios objectos de turma
			estudante = session.get(Turma.class, identificacao);
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
	 * Busca todos Turma
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Turma> getAllTurma() {

		Transaction transaction = null;
		List<Turma> listOfTurma = null;
		try (Session session = HibernateUtilTurma.getSessionFactory1().openSession()) {
			// inicia uma transacao
			transaction = session.beginTransaction();
			// busca varios objectos de turma
			
			listOfTurma = session.createQuery("from Turma").getResultList();//temos que referencia a nossa classe Turma
			
			// commit transacao
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfTurma;
	}

}