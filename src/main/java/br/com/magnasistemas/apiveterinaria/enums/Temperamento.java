package br.com.magnasistemas.apiveterinaria.enums;

public enum Temperamento {
	INDEPENDENTE,
	AGRESSIVO,
	DÓCIL,
	HIPERATIVO;
	
	public static Temperamento fromString(String value) {
        try {
            return Temperamento.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
