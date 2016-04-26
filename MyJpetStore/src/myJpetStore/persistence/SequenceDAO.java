package myJpetStore.persistence;

import myJpetStore.domain.Sequence;

public interface SequenceDAO {

	  Sequence getSequence(Sequence sequence);
	  
	  void updateSequence(Sequence sequence);

}
