package ki;

public abstract class Model {

	private Situation s;
	protected OptionsPool op;

	public Model() {
		this.op = loadOptionsPool();
		this.s = extractSituation();
	}

	public void updateModel() {
		update();
		this.s = extractSituation();
	}

	public abstract OptionsPool loadOptionsPool();

	public abstract Situation extractSituation();

	protected abstract void update();

	public OptionsPool getOptionsPool() {
		return op;
	}

	public Situation getSituation() {
		return new Situation(s);
	}

}
