import groovy.transform.Field

@Field final int DEFAULT_LENGTH = 255;
@Field int[] currentRow;
@Field int[] previousRow;

@Override
public int getDistance(CharSequence first, CharSequence second, int max=DEFAULT_LENGTH) {
    previousRow = new int[max + 1];
    currentRow = new int[max + 1];
    int firstLength = first.length();
    int secondLength = second.length();

    if (firstLength == 0)
        return secondLength;
    else if (secondLength == 0) return firstLength;

    if (firstLength > secondLength) {
        CharSequence tmp = first;
        first = second;
        second = tmp;
        firstLength = secondLength;
        secondLength = second.length();
    }

    if (max < 0) max = secondLength;
    if (secondLength - firstLength > max) return max + 1;

    if (firstLength > currentRow.length) {
        currentRow = new int[firstLength + 1];
        previousRow = new int[firstLength + 1];
    }

    for (int i = 0; i <= firstLength; i++)
        previousRow[i] = i;

    for (int i = 1; i <= secondLength; i++) {
        char ch = second.charAt(i - 1);
        currentRow[0] = i;

        // Вычисляем только диагональную полосу шириной 2 * (max + 1)
        int from = Math.max(i - max - 1, 1);
        int to = Math.min(i + max + 1, firstLength);
        for (int j = from; j <= to; j++) {
            // Вычисляем минимальную цену перехода в текущее состояние из предыдущих среди удаления, вставки и
            // замены соответственно.
            int cost = first.charAt(j - 1) == ch ? 0 : 1;
            currentRow[j] = Math.min(Math.min(currentRow[j - 1] + 1, previousRow[j] + 1), previousRow[j - 1] + cost);
        }

        Integer[] tempRow = previousRow;
        previousRow = currentRow;
        currentRow = tempRow;
    }
    return previousRow[firstLength];
}
println getDistance('back door', 'backdoor', 10)
