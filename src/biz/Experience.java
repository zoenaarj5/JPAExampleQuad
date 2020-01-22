package biz;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Experience extends Asset {
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Task> tasks;
}
