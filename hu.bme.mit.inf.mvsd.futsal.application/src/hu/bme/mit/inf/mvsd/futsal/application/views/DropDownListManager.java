package hu.bme.mit.inf.mvsd.futsal.application.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DropDownListManager<T>
{
	public static interface DDListListener<T>
	{
		void listChanged(List<T> available);
		void reinitialized(List<T> available);
	}
	
	List<T> fullList;
	List<T> available;
	List<T> selected;
	
	List<DropDownListManager.DDListListener<T>> listeners;
	
	public List<T> getFullList() {
		return Collections.unmodifiableList(fullList);
	}
	
	public List<T> getAvailable() {
		return Collections.unmodifiableList(available);
	}
	
	public List<T> getSelected() {
		return Collections.unmodifiableList(selected);
	}
	
	void addListener(DropDownListManager.DDListListener<T> listener) {
		listeners.add(listener);
	}
	
	void removeListener(DropDownListManager.DDListListener<T> listener) {
		listeners.remove(listener);
	}
	
	public DropDownListManager(Collection<T> fullList)
	{
		this.fullList = new ArrayList<>();
		this.fullList.addAll(fullList);
		available = new ArrayList<>();
		available.addAll(fullList);
		selected = new ArrayList<>();
		
		listeners = new ArrayList<>();
	}
	
	public void reinitialize(Collection<T> fullList)
	{
		this.fullList = new ArrayList<>();
		this.fullList.addAll(fullList);
		available = new ArrayList<>();
		available.addAll(fullList);
		selected = new ArrayList<>();
		
		for (DropDownListManager.DDListListener<T> listener : listeners) {
			listener.reinitialized(available);
		}
	}
	
	public boolean select(T element)
	{
		if (available.contains(element))
		{
			available.remove(element);
			selected.add(element);
			for (DropDownListManager.DDListListener<T> listener : listeners) {
				listener.listChanged(available);
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void deselect(T element)
	{
		if (selected.contains(element))
		{
			selected.remove(element);
			available.add(element);
			for (DropDownListManager.DDListListener<T> listener : listeners) {
				listener.listChanged(available);
			}
		}
	}
}