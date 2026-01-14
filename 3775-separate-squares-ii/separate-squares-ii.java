class Solution {
    static class Event implements Comparable<Event> {
        int y, type, xStart, xEnd;
        Event(int y, int type, int xStart, int xEnd) {
            this.y = y;
            this.type = type;
            this.xStart = xStart;
            this.xEnd = xEnd;
        }

        public int compareTo(Event other) {
            return Integer.compare(this.y, other.y);
        }
    }

    static class Strip {
        int y, height;
        double unionWidth;

        Strip(int y, int height, double unionWidth) {
            this.y = y;
            this.height = height;
            this.unionWidth = unionWidth;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> sweepEvents = new ArrayList<>();

        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], l = sq[2];
            sweepEvents.add(new Event(y, 1, x, x + l));
            sweepEvents.add(new Event(y + l, -1, x, x + l));
        }

        Collections.sort(sweepEvents);

        List<int[]> activeIntervals = new ArrayList<>();
        List<Strip> processedStrips = new ArrayList<>();

        double totalArea = 0;
        int prevY = sweepEvents.get(0).y;

        for (Event event : sweepEvents) {
            if (event.y > prevY) {
                double width = getUnionWidth(activeIntervals);
                int height = event.y - prevY;

                if (width > 0) {
                    processedStrips.add(new Strip(prevY, height, width));
                    totalArea += height * width;
                }
            }

            if (event.type == 1) {
                activeIntervals.add(new int[]{event.xStart, event.xEnd});
            } else {
                for (int i = 0; i < activeIntervals.size(); i++) {
                    int[] in = activeIntervals.get(i);
                    if (in[0] == event.xStart && in[1] == event.xEnd) {
                        activeIntervals.remove(i);
                        break;
                    }
                }
            }
            prevY = event.y;
        }

        double targetArea = totalArea / 2.0;
        double accumulatedArea = 0;

        for (Strip strip : processedStrips) {
            double stripArea = strip.height * strip.unionWidth;

            if (accumulatedArea + stripArea >= targetArea) {
                double need = targetArea - accumulatedArea;
                return strip.y + (need / strip.unionWidth);
            }
            accumulatedArea += stripArea;
        }
        return 0.0;
    }

    private double getUnionWidth(List<int[]> intervals) {
        if (intervals.isEmpty()) return 0;

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        double union = 0;
        double currentEnd = -1e18;

        for (int[] in : intervals) {
            int start = in[0], end = in[1];

            if (start >= currentEnd) {
                union += (end - start);
                currentEnd = end;
            } else if (end > currentEnd) {
                union += (end - currentEnd);
                currentEnd = end;
            }
        }
        return union;
    }
}
