package dao;

import java.util.List;

import domain.Computer;

public interface ComputerDao {
	public void addComputer(Computer c);

	public void updateComputer(Computer c);

	public List<Computer> getComputers();

	public Computer getComputerById(int id);

	public void removeComputer(int id);
}
