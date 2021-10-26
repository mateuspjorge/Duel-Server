package br.com.duelServer.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "TB_DUEL")
@GenericGenerator(
        name = "SEQ_DUEL",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_DUEL"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class Duel implements Serializable {

	private static final long serialVersionUID = 5373444505934303537L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DUEL")
	@Column(name = "ID_STATE", nullable = false)
	private Long id;

	@Column(name = "ID_CHAMPION", nullable = false)
	private Long champion;

	@Column(name = "ID_RIVAL", nullable = false)
	private Long rival;

	@Column(name = "ID_WINNER", nullable = true)
	private Long winner;

}