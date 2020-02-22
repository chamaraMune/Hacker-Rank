def process_answer(metroMap, totalRows, totalColumns):
    totalOccupiedArea = 0;

    for key, value in metroMap.items():
        value.sort(key=lambda interval: interval[0]);
        distinctIntervals = merge_overlapping_intervals(value);
        totalOccupiedArea += get_total_occupied_for_row(distinctIntervals);

    totalMapArea = get_total_map_area(totalRows, totalColumns);
    freeSpace = totalMapArea - totalOccupiedArea;

    return freeSpace;


def get_total_map_area(totalRows, totalColumns):
    return (totalRows * totalColumns);


def get_occupied_area_by_track(interval):
    lowerBound, upperBound = interval;
    occupiedSpace = (upperBound - lowerBound) + 1;
    return occupiedSpace;


def get_total_occupied_for_row(intervals):
    totalArea = 0;

    for interval in intervals:
        rowOccupied = get_occupied_area_by_track(interval);
        totalArea += rowOccupied;

    return totalArea;


def merge_overlapping_intervals(intervals):
    distinctIntervals = [];

    while(len(intervals) > 0):
        if (len(intervals) == 1):
            distinctIntervals.append(intervals[0]);
            intervals.pop(0);
            continue;

        if (intervals[0][1] >= intervals[1][0]):
            intervals[0] = [intervals[0][0], max(intervals[0][1], intervals[1][1])];
            intervals.pop(1);
            continue;

        distinctIntervals.append(intervals[0]);
        intervals.pop(0);

    return distinctIntervals;


if __name__ == "__main__":
    metaInput = input().rstrip().split(" ");
    rows, columns, tracks = [int(meta) for meta in metaInput];
    metroMap = {};
    trackIds = [];

    for (step) in range(tracks) :
        readLine = input().rstrip().split(" ");
        trackId, trackStart, trackEnd = [int(element) for element in readLine];
        trackCoordinates = [trackStart, trackEnd];
        trackCoordinates.sort();

        if trackId not in trackIds:
            trackIds.append(trackId);
            metroMap[str(trackId)] = [trackCoordinates];
            continue;

        metroMap[str(trackId)].append(trackCoordinates);

    lampPosts = process_answer(metroMap, rows, columns);
    print(lampPosts);
