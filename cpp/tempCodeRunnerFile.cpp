sort(p+i, p+n, [](const Process& a, const Process& b) {
            return a.priority < b.priority;
        });