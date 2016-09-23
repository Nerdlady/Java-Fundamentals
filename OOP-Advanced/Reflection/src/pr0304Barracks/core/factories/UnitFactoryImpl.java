package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit executable = null;
		try {
			Class unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor constructor = unit.getConstructor();
			executable = (Unit) constructor.newInstance();
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return executable;
	}
}
